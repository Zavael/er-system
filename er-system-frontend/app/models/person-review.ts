import { Person, Project } from '../models';

/**
 * UserReview
 */
export class PersonReview {
    public reviewer: Person;
    public reviewee: Person;
    public project: Project;
    public review: string;

    public agreements: number = 6;
    public disagreements: number = 2;
}