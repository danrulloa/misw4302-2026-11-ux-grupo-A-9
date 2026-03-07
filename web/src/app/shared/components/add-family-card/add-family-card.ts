import { Component, output } from '@angular/core';

@Component({
  selector: 'app-add-family-card',
  templateUrl: './add-family-card.html',
  styleUrl: './add-family-card.scss',
})
export class AddFamilyCard {
  addClicked = output<void>();

  onAdd(): void {
    this.addClicked.emit();
  }
}
