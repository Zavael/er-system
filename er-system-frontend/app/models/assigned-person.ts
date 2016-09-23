import { Person, Project, AssignedState } from '../models';

/**
 * AssignedUser
 */
export class AssignedPerson {
    private person: Person;
    private project: Project;
    private state: AssignedState;
    private isSupervisor: boolean;
    private position: String;
}