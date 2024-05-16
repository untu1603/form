import Repository from "@/api/Repository.js";

const resource = "/forms"

export default {
    getAll() {
        return Repository.get(`${resource}`);
    },

    getForm(formId) {
        return Repository.get(`${resource}/${formId}`);
    },

    createForm(payload){
        return Repository.post(`${resource}`,payload)
    },

    updateForm(formId,payload){
        return Repository.put(`${resource}/${formId}`,payload)
    },

    deleteForm(formId){
        return Repository.delete(`${resource}/${formId}`)
    }
}
