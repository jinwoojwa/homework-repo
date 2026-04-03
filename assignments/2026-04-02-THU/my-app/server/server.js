const express = require('express');
const path = require('path');
const fs = require('fs/promises');

const app = express();
const port = 3000;

const dataFilePath = path.join(__dirname, 'data.json');

app.use(express.json());
app.use((req, res, next) => {
  res.header('Access-Control-Allow-Origin', '*');
  res.header('Access-Control-Methods', 'GET, POST, PUT, PATCH, DELETE');
  next();
});

// GET /api/data : 전체 데이터 출력
app.get('/api/data', async (req, res) => {
  try {
    const data = await readDataFile();
    res.json({
      message: 'GET 요청 성공!',
      data: data,
    });
  } catch (error) {
    ``;
    res
      .status(500)
      .json({ message: 'Internal Server Error', detail: error.message });
  }
});

// GET /api/data/:id : 특정 id 데이터 출력
app.get('/api/data/:id', async (req, res) => {
  try {
    const targetId = Number(req.params.id);

    if (isNaN(targetId)) {
      return res.status(400).json({ error: 'Invalid ID' });
    }

    const data = await readDataFile();
    const item = data.find((item) => item.id === targetId);

    if (!item) {
      return res.status(404).json({ error: 'Not Found' });
    }

    res.json(item);
  } catch (error) {
    res.status(500).json({
      error: 'Internal Server Error',
      detail: error.message,
    });
  }
});

// POST /api/data
app.post('/api/data', async (req, res) => {
  try {
    const newData = req.body;
    const curData = await readDataFile();
    const newId = curData.length + 1;

    const createdData = {
      id: newId,
      name: newData.name,
      description: newData.description,
    };

    curData.push(createdData);
    await writeDataFile(curData);

    res.status(201).json(createdData);
  } catch (error) {
    res.status(500).json({
      message: 'Internal Server Error',
      detail: error.message,
    });
  }
});

// PUT /api/data/:id
app.put('/api/data/:id', async (req, res) => {
  try {
    const modifiedData = req.body;
    const curData = await readDataFile();
    const targetId = Number(req.params.id);

    const targetIdx = curData.findIndex((item) => item.id === targetId);

    if (targetIdx !== -1) {
      curData[targetIdx] = { ...curData[targetIdx], ...modifiedData };

      await writeDataFile(curData);

      res.json(curData[targetIdx]);
    } else {
      res.status(404).json({ error: 'Not Found' });
    }
  } catch (error) {
    res.status(500).json({
      error: 'Internal Server Error',
      detail: error.message,
    });
  }
});

// PATCH /api/data/:id
app.patch('/api/data/:id', async (req, res) => {
  try {
    const modifiedData = req.body;
    const curData = await readDataFile();
    const targetId = Number(req.params.id);

    const targetIdx = curData.findIndex((item) => item.id === targetId);

    if (targetIdx !== -1) {
      curData[targetIdx] = {
        ...curData[targetIdx],
        ...modifiedData,
      };

      await writeDataFile(curData);

      res.json(curData[targetIdx]);
    } else {
      res.status(404).json({ error: 'Not Found' });
    }
  } catch (error) {
    res.status(500).json({
      error: 'Internal Server Error',
      detail: error.message,
    });
  }
});

// DELETE /api/data/:id
app.delete('/api/data/:id', async (req, res) => {
  try {
    const curData = await readDataFile();
    const targetId = Number(req.params.id);

    const targetIdx = curData.findIndex((item) => item.id === targetId);

    if (targetIdx !== -1) {
      const deletedItem = curData[targetIdx];

      curData.splice(targetIdx, 1);

      await writeDataFile(curData);

      res.json({
        message: 'Deleted successfully',
        data: deletedItem,
      });
    } else {
      res.status(404).json({ error: 'Not Found' });
    }
  } catch (error) {
    res.status(500).json({
      error: 'Internal Server Error',
      detail: error.message,
    });
  }
});

// --------------------

async function readDataFile() {
  try {
    const data = await fs.readFile(dataFilePath, 'utf-8');

    if (!data.trim()) return [];

    return JSON.parse(data);
  } catch (error) {
    console.error('readDataFile error:', error.message);
    return [];
  }
}

async function writeDataFile(data) {
  await fs.writeFile(dataFilePath, JSON.stringify(data, null, 2), 'utf-8');
}

// 서버 실행
app.listen(port, () => {
  console.log(`Server is running at http://localhost:${port}`);
});
