import {Eroles} from "../../shared/constans/eroles.string";

export class User {
  id?: number;
  username?: string;
  email?: string;
  locked?: boolean;
  enabled?: boolean;
  roles?: Eroles[];
}
