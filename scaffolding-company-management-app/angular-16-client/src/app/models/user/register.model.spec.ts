import {RegisterRequest} from './register.model';

describe('UserRegister', () => {
  it('should create an instance', () => {
    expect(new RegisterRequest()).toBeTruthy();
  });
});
