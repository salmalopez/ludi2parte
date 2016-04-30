var World = {
	loaded: false,

	init: function initFn() {
		this.createOverlays();
	},

	createOverlays: function createOverlaysFn() {
		// Initialize ClientTracker
		this.tracker = new AR.ClientTracker("assets/tracker.wtc", {
			onLoaded: this.worldLoaded
		});

		/*
			Besides images, text and HTML content you are able to display videos in augmented reality. With the help of AR.VideoDrawables you can add a video on top of any image recognition target (AR.Trackable2DObject) or have it displayed at any geo location (AR.GeoObject). Like any other drawable you can position, scale, rotate and change the opacity of the video drawable.

			The video we use for this example is "video.mp4". As with all resources the video can be loaded locally from the application bundle or remotely from any server. In this example the video file is already bundled with the application.

			The URL and the size are required when creating a new AR.VideoDrawable. Optionally the offsetX and offsetY parameters are set to position the video on the target. The values for the offsets are in SDUs. If you want to know more about SDUs look up the code reference.
		*/
/*		var video = new AR.VideoDrawable("assets/ludi.mp4", 0.40, {
							offsetX: 0,
							offsetY: 0
        				});
*/
        var videofyv = new AR.VideoDrawable("assets/frutas_verduras.mp4", 0.40, {
							offsetX: 0,
							offsetY: 0
        				});

        var videocereales = new AR.VideoDrawable("assets/cereales_tuberculos.mp4", 0.40, {
                			offsetX: 0,
                            offsetY: 0
                		});

        var videocarne = new AR.VideoDrawable("assets/leguminosas.mp4", 0.40, {
                			offsetX: 0,
                            offsetY: 0
                		});

        var videoplato = new AR.VideoDrawable("assets/plato_bien_comer.mp4", 0.40, {
                			offsetX: 0,
                            offsetY: 0
                		});
/*
        var videojarra = new AR.VideoDrawable("assets/ludi.mp4", 0.40, {
                 			offsetX: 0,
                            offsetY: 0
                 		});
*/
		/*
			Adding the video to the image target is straight forward and similar like adding any other drawable to an image target.

			Note that this time we use "*" as target name. That means that the AR.Trackable2DObject will respond to any target that is defined in the target collection. You can use wildcards to specify more complex name matchings. E.g. 'target_?' to reference 'target_1' through 'target_9' or 'target*' for any targets names that start with 'target'.

			To start the video immediately after the target is recognized we call play inside the onEnterFieldOfVision trigger. Supplying -1 to play tells the Wikitude SDK to loop the video infinitely. Choose any positive number to re-play it multiple times.
		*/

/*
		var pageOne = new AR.Trackable2DObject(this.tracker, "logo", {
                			drawables: {
                				cam: [video]
                			},
                			onEnterFieldOfVision: function onEnterFieldOfVisionFn() {
                				video.play(1);
                			},
                			onExitFieldOfVision: function onExitFieldOfVisionFn () {
                           		video.pause();
                            }

                		});
*/

		var pageTwo = new AR.Trackable2DObject(this.tracker, "verduras", {
                			drawables: {
                				cam: [videofyv]
                			},
                			onEnterFieldOfVision: function onEnterFieldOfVisionFn() {
                				videofyv.play(1);
                			},
                			onExitFieldOfVision: function onExitFieldOfVisionFn () {
                           		videofyv.pause();
                            }

                		});

		var pageThree = new AR.Trackable2DObject(this.tracker, "cereales", {
                			drawables: {
                				cam: [videocereales]
                			},
                			onEnterFieldOfVision: function onEnterFieldOfVisionFn() {
                				videocereales.play(1);
                			},
                			onExitFieldOfVision: function onExitFieldOfVisionFn () {
                           		videocereales.pause();
                            }

                		});

		var pageFour = new AR.Trackable2DObject(this.tracker, "carne", {
                			drawables: {
                				cam: [videocarne]
                			},
                			onEnterFieldOfVision: function onEnterFieldOfVisionFn() {
                				videocarne.play(1);
                			},
                			onExitFieldOfVision: function onExitFieldOfVisionFn () {
                           		videocarne.pause();
                            }

                		});


		var pageFive = new AR.Trackable2DObject(this.tracker, "plato", {
                			drawables: {
                				cam: [videoplato]
                			},
                			onEnterFieldOfVision: function onEnterFieldOfVisionFn() {
                				videoplato.play(1);
                			},
                			onExitFieldOfVision: function onExitFieldOfVisionFn () {
                           		videoplato.pause();
                            }

                		});

/*
		var pageSix = new AR.Trackable2DObject(this.tracker, "bebidas", {
                			drawables: {
                				cam: [videofyv]
                			},
                			onEnterFieldOfVision: function onEnterFieldOfVisionFn() {
                				videofyv.play(1);
                			},
                			onExitFieldOfVision: function onExitFieldOfVisionFn () {
                           		videofyv.pause();
                            }

                		});
*/


	},

	worldLoaded: function worldLoadedFn() {
		var cssDivInstructions = " style='display: table-cell;vertical-align: middle; text-align: right; width: 50%; padding-right: 15px;'";
		var cssDivSurfer = " style='display: table-cell;vertical-align: middle; text-align: left; padding-right: 15px; width: 38px'";
		var cssDivBiker = " style='display: table-cell;vertical-align: middle; text-align: left; padding-right: 15px;'";
		document.getElementById('loadingMessage').innerHTML =
            "<div" + cssDivInstructions + "></div>" +
            "<div" + cssDivSurfer + "></div>" +
            "<div" + cssDivBiker + "></div>";

		// Remove Scan target message after 10 sec.
		setTimeout(function() {
			var e = document.getElementById('loadingMessage');
			e.parentElement.removeChild(e);
		}, 10000);
	}
};

World.init();