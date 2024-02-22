import FormRepository from "@/api/FormRepository.js";

const repositories = {
    forms: FormRepository,
};

export const RepositoryFactory = {
    get: name => repositories[name]
};
