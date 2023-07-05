import {Eroles} from "./enums/eroles.string";

export interface IUserRegister {
  username?: string;
  email?: string;
  password?: string;
  role?: Eroles[];
}

export class UserRegister implements IUserRegister {
  constructor(public username?: string,
              email?: string,
              password?: string,
              role?: Eroles[]) {
  }
}
