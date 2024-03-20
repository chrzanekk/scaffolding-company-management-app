export interface IRequestPasswordReset {
  email?: string;
}

export class RequestPasswordReset implements IRequestPasswordReset {
  constructor(email?: string) {
  }
}
