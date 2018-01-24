import { ProjectReview, PersonReview } from '../models';

/**
 * User
 */
export class Person {
    public id: number;
    public userName: string;
    public password: string;
    public firstName: string;
    public surname: string;

    public projectReviews: ProjectReview[];
    public personReviews: PersonReview[];
    public ownReviews: PersonReview[];
}