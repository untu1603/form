import { defineStore } from 'pinia'
import {ref} from "vue";

export const formStore = defineStore(
    {
        id: 'form',
        state: () => ({
            formId: ref(null)
        }),
        actions: {

        }
    })
