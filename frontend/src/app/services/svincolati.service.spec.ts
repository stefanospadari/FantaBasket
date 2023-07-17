import { TestBed } from '@angular/core/testing';

import { SvincolatiService } from './svincolati.service';

describe('SvincolatiService', () => {
  let service: SvincolatiService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SvincolatiService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
