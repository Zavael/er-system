import { ProjectReview, PersonReview, AssignedPerson } from '../models';

/**
 * Project
 */
export class Project {
    public id: number;
    public name: string;
    public description: string;
    public started: Date;
    public finished: Date;

    public projectReviews: ProjectReview[];
    public personReviews: PersonReview[];
    public assignedPersons: AssignedPerson[];
}