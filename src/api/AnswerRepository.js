import Repository from "@/api/Repository.js";

const resource = "/answers"

export default {
    getAll() {
        return Repository.get(`${resource}`);
    },

    get(answerId) {
        return Repository.get(`${resource}/${answerId}`);
    },

    create(payload){
        return Repository.post(`${resource}`,payload)
    },

    update(answerId,payload){
        return Repository.put(`${resource}/${answerId}`,payload)
    },

    delete(answerId){
        return Repository.delete(`${resource}/${answerId}`)
    }
}
