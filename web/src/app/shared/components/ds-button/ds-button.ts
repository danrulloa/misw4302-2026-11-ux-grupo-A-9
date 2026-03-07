import { Component, input, output } from '@angular/core';

@Component({
  selector: 'app-ds-button',
  templateUrl: './ds-button.html',
  styleUrl: './ds-button.scss',
})
export class DsButton {
  label = input.required<string>();
  icon = input('');
  variant = input<'primary' | 'accent'>('primary');
  buttonType = input<'button' | 'submit'>('button');
  clicked = output<void>();

  onClick(): void {
    this.clicked.emit();
  }
}
