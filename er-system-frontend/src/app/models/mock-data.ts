
var possibleUpper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
var possibleLower = "abcdefghijklmnopqrstuvwxyz";
var possibleNumbers = "0123456789";

export function designation(wordMaxLength?: number): string {
    if (!wordMaxLength || wordMaxLength < 5) wordMaxLength = 10;
    let text = '';
    let finalLength = Math.floor(Math.random() * (wordMaxLength - 3)) + 3;

    text += possibleUpper.charAt(Math.floor(Math.random() * possibleUpper.length));
    for (var index = 0; index < finalLength; index++) {
        text += possibleLower.charAt(Math.floor(Math.random() * possibleLower.length));
    }

    return text;
}

export function word(wordMaxLength?: number): string {
    if (!wordMaxLength || wordMaxLength < 5) wordMaxLength = 10;
    let text = '';
    let finalLength = Math.floor(Math.random() * (wordMaxLength - 3)) + 3;

    for (var index = 0; index < finalLength; index++) {
        text += possibleLower.charAt(Math.floor(Math.random() * possibleLower.length));
    }

    return text;
}

export function paragraph(wordMaxCount?: number): string {
    if (!wordMaxCount) wordMaxCount = 20;
    let text = '';
    let finalCount = wordMaxCount;

    text += designation(10);
    for (var index = 0; index < finalCount; index++) {
        text += ' ' + word(10);
    }
    text += '.';

    return text;
}