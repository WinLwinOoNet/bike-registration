import { Component, OnDestroy, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Subscription } from 'rxjs';
import { BikeService } from 'src/app/services/bike.service';

@Component({
  selector: 'app-view-registration',
  templateUrl: './view-registration.component.html',
  styleUrls: ['./view-registration.component.css'],
})
export class ViewRegistrationComponent implements OnInit, OnDestroy {
  private sub: Subscription;

  public bikeReg;

  constructor(
    private route: ActivatedRoute,
    private bikeService: BikeService
  ) {}

  ngOnInit(): void {
    this.sub = this.route.paramMap.subscribe((params) => {
      const id = params.get('id');
      this.getBikeReg(id);
    });
  }

  ngOnDestroy(): void {
    this.sub.unsubscribe();
  }

  getBikeReg(id): void {
    this.bikeService.getBike(id).subscribe(
      (data) => (this.bikeReg = data),
      (err) => console.error(err),
      () => console.log('Bike loaded')
    );
  }
}
