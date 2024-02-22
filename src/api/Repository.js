import axios from "axios";

const baseDomain = "http://localhost:8080"
export default axios.create({
    baseURL:`${baseDomain}`,
    headers: {"Authorization": "Bearer "}
})
