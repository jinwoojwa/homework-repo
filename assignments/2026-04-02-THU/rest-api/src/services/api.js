import axios from 'axios';

export const getData = () => axios.get('/api/data');

export const postData = (data) => axios.post('/api/data', data);

export const putData = (id, data) => axios.put(`/api/data/${id}`, data);

export const patchData = (id, data) => axios.patch(`/api/data/${id}`, data);

export const deleteData = (id) => axios.delete(`/api/data/${id}`);
