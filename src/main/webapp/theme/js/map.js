var map = L.map('map').setView([0, 0], 1);
L.tileLayer('https://api.maptiler.com/maps/streets/256/{z}/{x}/{y}.png?key=ixVGSmstXYLqCiYGqt5g', {
    attribution: '<a href="https://www.maptiler.com/copyright/" target="_blank">&copy; MapTiler</a> <a href="https://www.openstreetmap.org/copyright" target="_blank">&copy; OpenStreetMap contributors</a>',
}).addTo(map);

var marker = L.marker = L.marker([50.01587080670589, 19.92471247670811]).addTo(map);

marker.bindPopup("Camping").openPopup();
