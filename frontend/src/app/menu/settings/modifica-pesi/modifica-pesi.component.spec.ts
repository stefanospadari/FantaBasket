import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ModificaPesiComponent } from './modifica-pesi.component';

describe('ModificaPesiComponent', () => {
  let component: ModificaPesiComponent;
  let fixture: ComponentFixture<ModificaPesiComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ModificaPesiComponent]
    });
    fixture = TestBed.createComponent(ModificaPesiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
