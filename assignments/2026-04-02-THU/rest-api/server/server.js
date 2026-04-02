// 서버 구성 (Express)
const express = require('express');
const fs = require('fs/promises');
const path = require('path');

// express app 생성
const app = express();

const port = 3000;

const dataFilePath = path.join(__dirname, 'data.json');

app.use(express.json());
app.use((req, res, next) => {
  res.header('Access-Control-Allow-Origin', '*');
  res.header('Access-Control-Methods', 'GET, POST, PUT, PATCH, DELETE');
  next();
});

// 서버에서 제공하는 메서드
// 전체 데이터 조회:             GET /api/data
// 새 데이터 추가:               POST /api/data
// 특정 데이터 전체 수정:        PUT /api/data/:id
// 특정 데이터 일부 수정:        PATCH /api/data/:id
// 특정 데이터 삭제:             DELETE /api/data/:id

app.get('/api/data', async (req, res) => {
  try {
    const data = await readDataFile();
    res.json({
      message: 'GET 요청 성공!',
      data: data,
    });
  } catch (error) {
    res.status(500).json({ error: 'Internal Server Error' });
  }
});

app.post('/api/data', async (req, res) => {
  try {
    const newData = req.body;
    const data = await readDataFile();
    const writeData = {
      id: data.length + 1,
      name: `${newData.name} ${data.length + 1}`,
      description: `${newData.description} ${data.length + 1}`,
    };
    data.push(writeData);
    await writeDataFile(data);
    res.json(writeData);
  } catch (error) {
    console.log(error);
    res.status(500).json({ error: 'Internal Server Error' });
  }
});

app.put('/api/data/:id', async (req, res) => {
  try {
    // URL의 id 값을 숫자로 변환
    // 예: /api/data/3 -> 3
    const id = Number(req.params.id);

    // 클라이언트가 보낸 수정 데이터
    const updatedData = req.body;

    // 파일에서 기존 데이터 읽기
    const data = await readDataFile();

    // 해당 id를 가진 데이터의 위치(index) 찾기
    const index = data.findIndex((item) => item.id === id);

    // 해당 데이터가 존재하면
    if (index !== -1) {
      data[index] = { ...data[index], ...updatedData };

      // 수정된 전체 배열을 파일에 저장
      await writeDataFile(data);

      // 수정된 데이터 응답
      res.json(data[index]);
    } else {
      // id에 해당하는 데이터가 없으면 404 응답
      res.status(404).json({ error: 'Not Found' });
    }
  } catch (error) {
    // 서버 내부 오류 응답
    res.status(500).json({ error: 'Internal Server Error' });
  }
});

// ==============================
// PATCH: 데이터 부분 업데이트하기
// 주소: PATCH /api/data/:id
// 기능: 특정 id의 데이터 일부만 수정
// ==============================
app.patch('/api/data/:id', async (req, res) => {
  try {
    const id = Number(req.params.id);
    const partialData = req.body;

    const data = await readDataFile();
    const index = data.findIndex((item) => item.id === id);

    if (index !== -1) {
      data[index] = { ...data[index], ...partialData };
      await writeDataFile(data);
      res.json(data[index]);
    } else {
      res.status(404).json({ error: 'Not Found' });
    }
  } catch (error) {
    res.status(500).json({ error: 'Internal Server Error' });
  }
});

// ==============================
// DELETE: 데이터 삭제하기
app.delete('/api/data/:id', async (req, res) => {
  try {
    const id = Number(req.params.id);
    const data = await readDataFile();
    const index = data.findIndex((item) => item.id === id);

    if (index !== -1) {
      const deletedItem = data.splice(index, 1)[0];
      await writeDataFile(data);

      res.json(deletedItem);
    } else {
      res.status(404).json({ error: 'Not Found' });
    }
  } catch (error) {
    res.status(500).json({ error: 'Internal Server Error' });
  }
});

async function readDataFile() {
  const data = await fs.readFile(dataFilePath, 'utf-8');
  return data ? JSON.parse(data) : [];
}

async function writeDataFile(data) {
  await fs.writeFile(dataFilePath, JSON.stringify(data, null, 2), 'utf-8');
}

// 서버 실행
app.listen(port, () => {
  console.log(`Server is running at http://localhost${port}`);
});
