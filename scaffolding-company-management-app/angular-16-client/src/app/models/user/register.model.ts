import {Eroles} from "../enums/eroles.string";

export interface IRegisterRequest {
  username?: string;
  email?: string;
  password?: string;
  role?: Eroles[];
}

export class RegisterRequest implements IRegisterRequest {
  constructor(public username?: string,
              email?: string,
              password?: string,
              role?: Eroles[]) {
  }
}
