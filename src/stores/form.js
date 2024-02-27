import { defineStore } from 'pinia'
import {FormModel} from "@/models/FormModel.js";
export const formStore = defineStore(
    {
        id: 'formEdit',
        state: () => ({
            form: FormModel,
            search: "",
        }),
        actions: {
        }
    })

