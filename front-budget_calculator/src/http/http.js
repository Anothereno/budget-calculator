import axios from 'axios'

let budgetAPI = axios.create({
  baseURL: "http://localhost:12319/"
});

export {budgetAPI}
