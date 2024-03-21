import {Eroles} from "../../shared/constans/eroles.string";

export class Account {
  constructor(
    public id?: number,
    public email?: string,
    public username?: string,
    public roles?: Eroles[]
  ) {
  }
}
