import { Review, User } from '../models';

/**
 * Project
 */
export class Project {
    public name:string;
    public description:string;

    public projectReviews: Review[];
    public assignedUsers: User[];
}