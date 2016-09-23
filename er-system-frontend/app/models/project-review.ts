import { Person, Project } from '../models';

/**
 * Review
 */
export class ProjectReview {
    public reviewer: Person;
    public project: Project;
    public review: string;

    public agreements: number = 6;
    public disagreements: number = 2;
}