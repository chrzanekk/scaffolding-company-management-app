import {Eroles} from "./enums/eroles.string";

export class Account {
  constructor(
    public email: any,
    public username: any,
    public password: string,
    public locked: boolean,
    public enabled: boolean,
    public authorities: Eroles[]
  ) {
  }
}
