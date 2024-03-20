export interface IPasswordReset {
  password?: string;
  confirmPassword?: string;
}

export class PasswordReset implements IPasswordReset {
  constructor(password?: string,
              confirmPassword?: string) {
  }
}
