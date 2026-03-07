import { Component, output, signal } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-time-picker',
  imports: [FormsModule],
  templateUrl: './time-picker.html',
  styleUrl: './time-picker.scss',
})
export class TimePicker {
  selected = output<string>();
  cancelled = output<void>();

  mode = signal<'dial' | 'keyboard'>('dial');
  selectedHour = signal(7);
  minutes = signal('00');
  period = signal<'AM' | 'PM'>('AM');

  hours = Array.from({ length: 12 }, (_, i) => i + 1);

  selectHour(h: number): void {
    this.selectedHour.set(h);
  }

  toggleMode(): void {
    this.mode.update(m => m === 'dial' ? 'keyboard' : 'dial');
  }

  onOk(): void {
    const h = this.selectedHour().toString().padStart(2, '0');
    this.selected.emit(`${h}:${this.minutes()} ${this.period()}`);
  }

  onCancel(): void {
    this.cancelled.emit();
  }
}
