import { defineStore } from 'pinia'
import {ref} from "vue";
import {FormModel} from "@/models/FormModel.js";
export const formStore = defineStore(
    {
        id: 'formEdit',
        state: () => ({
            form: ref(FormModel),
            search: ""
        }),
        actions: {
        }
    })

