import {Eroles} from "./enums/eroles.string";

export class Account {
  constructor(
    public id?: number,
    public email?: string,
    public username?: string,
    public roles?: Eroles[]
  ) {
  }
}
