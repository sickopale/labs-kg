function rgbToHls(r, g, b) {

    r /= 255;
    g /= 255;
    b /= 255;

    const max = Math.max(r, g, b);
    const min = Math.min(r, g, b);

    let h, s, l;

    l = (max + min) / 2;

    if (max === min) {
        h = s = 0; // оттенок не определен, насыщенность 0
    } else {
        const d = max - min;
        s = l > 0.5 ? d / (2 - max - min) : d / (max + min);

        switch (max) {
            case r:
                h = (g - b) / d + (g < b ? 6 : 0);
                break;
            case g:
                h = (b - r) / d + 2;
                break;
            case b:
                h = (r - g) / d + 4;
                break;
        }

        h /= 6;
    }

    h = Math.round(h * 360);
    s = Math.round(s * 100);
    l = Math.round(l * 100);

    return [h, s, l];
}

function rgbToCmyk(r,g,b){
    let k=Math.min(1-r/255,1-g/255,1-b/255);
    let c=(1-r/255-k)/(1-k);
    let m=(1-g/255-k)/(1-k);
    let y=(1-b/255-k)/(1-k);
    return [Math.round(c*100),Math.round(m*100),Math.round(y*100),Math.round(k*100)];
}

function cmykToRgb(c,m,y,k){
    let r=255*(1-c/100)*(1-k/100);
    let g=255*(1-m/100)*(1-k/100);
    let b=255*(1-y/100)*(1-k/100) ;
    return [Math.round(r),Math.round(g),Math.round(b)];
}

function componentToHex(c) {
    let hex = (+c).toString(16);
    return hex.length == 1 ? "0" + hex : hex;
}

function rgbToHex(r, g, b) {
    return "#" + componentToHex(r) + componentToHex(g) + componentToHex(b);
}

function hlsToRgb(h, l, s) {

    l /= 100;
    s /= 100;

    const c = (1 - Math.abs(2 * l - 1)) * s;
    const x = c * (1 - Math.abs(((h / 60) % 2) - 1));
    const m = l - c / 2;

    let r, g, b;

    if (h >= 0 && h < 60) {
        r = c;
        g = x;
        b = 0;
    } else if (h >= 60 && h < 120) {
        r = x;
        g = c;
        b = 0;
    } else if (h >= 120 && h < 180) {
        r = 0;
        g = c;
        b = x;
    } else if (h >= 180 && h < 240) {
        r = 0;
        g = x;
        b = c;
    } else if (h >= 240 && h < 300) {
        r = x;
        g = 0;
        b = c;
    } else {
        r = c;
        g = 0;
        b = x;
    }

    r = Math.round((r + m) * 255);
    g = Math.round((g + m) * 255);
    b = Math.round((b + m) * 255);

    return [r, g, b];
}

