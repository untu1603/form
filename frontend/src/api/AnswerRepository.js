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

    statistic(formId){
        return Repository.get(`${resource}/statistic/${formId}`)
    },
    delete(answerId){
        return Repository.delete(`${resource}/${answerId}`)
    }
}
