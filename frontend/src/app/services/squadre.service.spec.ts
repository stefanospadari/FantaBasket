import { TestBed } from '@angular/core/testing';

import { SquadreService } from './squadre.service';

describe('SquadreService', () => {
  let service: SquadreService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SquadreService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
