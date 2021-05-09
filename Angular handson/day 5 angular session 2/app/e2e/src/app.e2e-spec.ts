import { browser, element, logging, by } from 'protractor';
import { AppPage } from './app.po';

describe('workspace-project App', () => {
  let page: AppPage;

  beforeEach(() => {
    browser.get('');
  });

  var search = element(by.id('search'));
  it('should have search', async () => {
    browser.get('employeeList');
    expect(search).toBeTruthy();
  });

  var salary = element(by.id('salary'));
  it('should have salary field', () => {
    browser.get('editReactive/1');
    expect(salary).toBeTruthy();
  });

  var quantity = element(by.id('num'));
  var pressButton = element(by.id('inc'));
  it('should increase the quantity', () => {
    browser.get('quantity');
    pressButton.click();
    expect<any>(quantity.getText()).toEqual('1');
  });
});
