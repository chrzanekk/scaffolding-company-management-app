import {Eroles} from "./enums/eroles.string";

export class Account {
  constructor(
    public email: string,
    public username: string,
    public password: string,
    public locked: boolean,
    public enabled: boolean,
    public authorities: Eroles[]
  ) {
  }
}
