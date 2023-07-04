import {Eroles} from "./enums/eroles.string";

export class JwtResponse {
  id?: number;
  username?: string;
  email?: string;
  roles?: Eroles[];
    tokenType?: string;
  accessToken?: string;
}
