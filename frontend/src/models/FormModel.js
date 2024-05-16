
export const FormModel ={
    formId: null,
    userId: null,
    header: null,
    description: null,
    screenShot: null,
    questions: [],
    createdDate: null,
    lastUpdatedTime: null,
}
export const QuestionModel ={
    type: Number,
    content: String,
    choices: [],
}
export const AnswerModel ={
    formId: null,
    userId: null,
    contents: [],
}
export class ContentModel {
    constructor() {
        this.checkBox= [];
        this.multipleChoice =null;
        this.paragraph =null;
    }

}
export class QuestionClass {
    constructor(type) {
        this.type = type;
        this.choices = [];
    }
}
export class FormClass {
    constructor(header) {
        this.header = header;
        this.questions = [];
    }
}
