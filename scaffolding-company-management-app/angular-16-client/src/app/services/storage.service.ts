import {Injectable} from '@angular/core';
import {LocalStorageKey} from "../models/enums/local-storage-key.model";

@Injectable({
  providedIn: 'root'
})
export class StorageService {

  constructor() { }

  addItemsToLocalStorage(itemsForAdd: any[], key: LocalStorageKey | string): void {
    if (itemsForAdd && itemsForAdd.length > 0) {
      const storageItems: any[] = this.getItemsFromLocalStorage(key);
      itemsForAdd = this.removeDuplicatedItems(itemsForAdd, storageItems);
      if (storageItems && storageItems.length > 0) itemsForAdd.push(...storageItems);
      // clear local storage before adding new list
      localStorage.removeItem(key);
      localStorage.setItem(key, JSON.stringify(itemsForAdd));
    }
  }

  removeItemFromLocalStorage(item: any, key: LocalStorageKey | string): void {
    const storageItems: any[] = this.getItemsFromLocalStorage(key);
    const indexForDelete = storageItems.findIndex(x => x.id === item.id);
    if (indexForDelete !== -1) {
      storageItems.splice(indexForDelete, 1);
      localStorage.removeItem(key);
      localStorage.setItem(key, JSON.stringify(storageItems));
    }
  }

  protected removeDuplicatedItems(selectedItems: any[], itemsFromStorage: any[]): any[] {
    const copiedList: any[] = [];
    selectedItems.forEach(x => {
      const exists = itemsFromStorage.some(itemFromStorage => itemFromStorage.id === x.id);
      if (!exists) copiedList.push(x);
    });
    return copiedList;
  }

  addItemToLocalStorage(item: any, key: LocalStorageKey | string): void {
    if (item) {
      this.addItemsToLocalStorage([item], key);
    }
  }

  removeItemsFromLocalStorage(key: LocalStorageKey | string): void {
    localStorage.removeItem(key);
  }

  getItemsFromLocalStorage(key: LocalStorageKey | string): any[] {
    const selectedElements = localStorage.getItem(key);
    if (selectedElements) {
      const elements: any[] = JSON.parse(selectedElements);
      return elements;
    } else {
      return [];
    }
  }

  saveItemToLocalStorage(key: LocalStorageKey, fields: any[]): void {
    localStorage.setItem(key, JSON.stringify(fields));
  }

}
