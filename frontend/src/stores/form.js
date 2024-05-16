import { defineStore } from 'pinia'
import {FormModel} from "@/models/FormModel.js";
export const formStore = defineStore(
    {
        id: 'formEdit',
        state: () => ({
            form: FormModel,
            search: "",
            userIdMock:"3fa85f64-5717-4562-b3fc-2c963f66afa6"
        }),
        actions: {
        }
    })

