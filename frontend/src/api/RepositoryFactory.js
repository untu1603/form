import FormRepository from "@/api/FormRepository.js";
import AnswerRepository from "@/api/AnswerRepository.js";

const repositories = {
    forms: FormRepository,
    answers: AnswerRepository
};

export const RepositoryFactory = {
    get: name => repositories[name]
};
