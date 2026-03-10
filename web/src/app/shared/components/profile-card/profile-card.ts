import { Component, input, output } from '@angular/core';

@Component({
  selector: 'app-profile-card',
  templateUrl: './profile-card.html',
  styleUrl: './profile-card.scss',
})
export class ProfileCard {
  initials = input.required<string>();
  profileName = input.required<string>();
  relation = input.required<string>();
  enterClicked = output<void>();

  onEnter(): void {
    this.enterClicked.emit();
  }
}
