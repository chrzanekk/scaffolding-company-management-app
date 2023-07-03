
export interface IFuelType {
  id?: number;
  name?: string;
}

export class FuelType implements IFuelType{
  constructor(public id?: number, public name?: string) {
  }
}
