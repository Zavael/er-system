import { User, Project } from '../models';

/**
 * Review
 */
export class ProjectReview {
    public author: User;
    public reviewedProject: Project;
    public content: string;
}