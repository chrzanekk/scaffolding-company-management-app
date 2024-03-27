export interface IPasswordReset {
  token?: string;
  password?: string;
  confirmPassword?: string;
}

export class PasswordReset implements IPasswordReset {
  constructor(
    token?: string,
    password?: string,
    confirmPassword?: string) {
  }
}
