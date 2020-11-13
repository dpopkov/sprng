import { FormControl, ValidationErrors } from '@angular/forms';

export class ShopValidators {

    // Whitespace validation
    static notOnlyWhitespace(control: FormControl): ValidationErrors {
        // Check if the string only contains whitespace
        if ((control.value != null) && (control.value.trim().length === 0)) {
            // invalid, return error object
            return { 'notOnlyWhitespace': true };
        } else {
            // valid, return null
            return null;
        }
    }
}
