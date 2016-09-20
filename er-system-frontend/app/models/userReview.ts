import { User } from '../models';

/**
 * UserReview
 */
export class UserReview {
    public author: User;
    public reviewedUser: User;
    public content: string;
}