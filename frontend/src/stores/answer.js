import { defineStore } from 'pinia'
import {AnswerModel, ContentModel} from "@/models/FormModel.js";
export const answerStore = defineStore(
    {
        id: 'answer',
        state: () => ({
            answer: AnswerModel
        }),
        actions: {
            createAnswerNew(number){
                    this.answer.contents = []
                for (let i = 0; i < number; i++) {
                    this.answer.contents.push(new ContentModel())
                }
            }
        }
    })



