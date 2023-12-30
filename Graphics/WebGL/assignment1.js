
var gl;
var points;

window.onload = function init()
{
    var canvas = document.getElementById( "gl-canvas" );

    gl = WebGLUtils.setupWebGL( canvas );
    if ( !gl ) { alert( "WebGL isn't available" ); }


    // sky
    var v_sky = [
        vec2(-1, 1),
        vec2(-1, -0.4),
        vec2(1, 1),
        vec2(1, -0.4)
    ];

    var c_sky = [
        vec4(51/255, 102/255, 204/255, 1.0),
        vec4(153/255, 255/255, 255/255, 1.0),
        vec4(51/255, 102/255, 204/255, 1.0),
        vec4(153/255, 255/255, 255/255, 1.0)
    ];

    // sun
    pi = 2 * Math.PI
    r = 0.18
    var v_sun = [
        vec2(-0.6, 0.7),

        vec2(-0.6 + Math.cos(0/360 * pi) * r, 0.7 + Math.sin(0/360 * pi) * r),
        vec2(-0.6 + Math.cos(22.5/360 * pi) * r, 0.7 + Math.sin(22.5/360 * pi) * r),
        vec2(-0.6 + Math.cos(45/360 * pi) * r, 0.7 + Math.sin(45/360 * pi) * r),
        vec2(-0.6 + Math.cos(67.5/360 * pi) * r, 0.7 + Math.sin(67.5/360 * pi) * r),

        vec2(-0.6 + Math.cos(90/360 * pi) * r, 0.7 + Math.sin(90/360 * pi) * r),
        vec2(-0.6 + Math.cos(112.5/360 * pi) * r, 0.7 + Math.sin(112.5/360 * pi) * r),
        vec2(-0.6 + Math.cos(135/360 * pi) * r, 0.7 + Math.sin(135/360 * pi) * r),
        vec2(-0.6 + Math.cos(157.5/360 * pi) * r, 0.7 + Math.sin(157.5/360 * pi) * r),
        
        vec2(-0.6 + Math.cos(180/360 * pi) * r, 0.7 + Math.sin(180/360 * pi) * r),
        vec2(-0.6 + Math.cos(202.5/360 * pi) * r, 0.7 + Math.sin(202.5/360 * pi) * r),
        vec2(-0.6 + Math.cos(225/360 * pi) * r, 0.7 + Math.sin(225/360 * pi) * r),
        vec2(-0.6 + Math.cos(247.5/360 * pi) * r, 0.7 + Math.sin(247.5/360 * pi) * r),
    
        vec2(-0.6 + Math.cos(270/360 * pi) * r, 0.7 + Math.sin(270/360 * pi) * r),
        vec2(-0.6 + Math.cos(292.5/360 * pi) * r, 0.7 + Math.sin(292.5/360 * pi) * r),
        vec2(-0.6 + Math.cos(315/360 * pi) * r, 0.7 + Math.sin(315/360 * pi) * r),
        vec2(-0.6 + Math.cos(337.5/360 * pi) * r, 0.7 + Math.sin(337.5/360 * pi) * r),

        vec2(-0.6 + Math.cos(360/360 * pi) * r, 0.7 + Math.sin(360/360 * pi) * r)
    ];

    var c_sun = [
        vec4(230/255, 0, 0, 1.0),
        vec4(1, 0, 0, 1.0),
        vec4(1, 0, 0, 1.0),
        vec4(1, 0, 0, 1.0),
        vec4(1, 0, 0, 1.0),
        vec4(1, 0, 0, 1.0),
        vec4(1, 0, 0, 1.0),
        vec4(1, 0, 0, 1.0),
        vec4(1, 0, 0, 1.0),
        vec4(1, 0, 0, 1.0),
        vec4(1, 0, 0, 1.0),
        vec4(1, 0, 0, 1.0),
        vec4(1, 0, 0, 1.0),
        vec4(1, 0, 0, 1.0),
        vec4(1, 0, 0, 1.0),
        vec4(1, 0, 0, 1.0),
        vec4(1, 0, 0, 1.0),
        vec4(1, 0, 0, 1.0)
    ];

    // pinwheel_line
    var v_pinwheel_line = [
        vec2(-0.7, -0.1),
        vec2(-0.7, -1),

        vec2(-0.2, 0),
        vec2(-0.2, -1),

        vec2(0.3, -0.3),
        vec2(0.3, -1),

        vec2(0.7, 0),
        vec2(0.7, -1),
    ];

    var c_pinwheel_line = [
        vec4(0, 0, 0, 1.0),
        vec4(0, 0, 0, 1.0),
        vec4(0, 0, 0, 1.0),
        vec4(0, 0, 0, 1.0),
        vec4(0, 0, 0, 1.0),
        vec4(0, 0, 0, 1.0),
        vec4(0, 0, 0, 1.0),
        vec4(0, 0, 0, 1.0)
    ];

    a = 0.2
    b = 0.05
    c = 0.075


    // pinwheel
    var v_pinwheel = [
        vec2(-0.7, -0.1),

        vec2(-0.7 + a, -0.1 + a),
        vec2(-0.7 + b, -0.1 + a),
        vec2(-0.7 - c, -0.1 + c),

        vec2(-0.7 - a, -0.1 + a),
        vec2(-0.7 - a, -0.1 + b),
        vec2(-0.7 - c, -0.1 - c),

        vec2(-0.7 - a, -0.1 - a),
        vec2(-0.7 - b, -0.1 - a),
        vec2(-0.7 + c, -0.1 - c),

        vec2(-0.7 + a, -0.1 - a),
        vec2(-0.7 + a, -0.1 - b),
        vec2(-0.7 + c, -0.1 + c)
    ];

    // pinwheel color 1
    var c_pinwheel_1 = [
        vec4(240/255, 240/255, 0, 1.0),

        vec4(240/255, 240/255, 0, 1.0),
        vec4(240/255, 240/255, 0, 1.0),
        vec4(1, 1, 1, 1.0),

        vec4(240/255, 240/255, 0, 1.0),
        vec4(1, 1, 1, 1.0),
        vec4(1, 1, 1, 1.0),

        vec4(240/255, 240/255, 0, 1.0),
        vec4(1, 1, 1, 1.0),
        vec4(1, 1, 1, 1.0),

        vec4(240/255, 240/255, 0, 1.0),
        vec4(1, 1, 1, 1.0),
        vec4(1, 1, 1, 1.0),
    ];

    // pinwheel color 2
    var c_pinwheel_2 = [
        vec4(0, 153/255, 0, 1.0),

        vec4(0, 153/255, 0, 1.0),
        vec4(1, 1, 1, 1.0),
        vec4(1, 1, 1, 1.0),

        vec4(0, 153/255, 0, 1.0),
        vec4(1, 1, 1, 1.0),
        vec4(1, 1, 1, 1.0),

        vec4(0, 153/255, 0, 1.0),
        vec4(1, 1, 1, 1.0),
        vec4(1, 1, 1, 1.0),

        vec4(0, 153/255, 0, 1.0),
        vec4(1, 1, 1, 1.0),
        vec4(1, 1, 1, 1.0),
    ];

    // pinwheel color 3
    var c_pinwheel_3 = [
        vec4(0, 0, 102/255, 1.0),

        vec4(0, 0, 102/255, 1.0),
        vec4(1, 1, 1, 1.0),
        vec4(1, 1, 1, 1.0),

        vec4(0, 0, 102/255, 1.0),
        vec4(1, 1, 1, 1.0),
        vec4(1, 1, 1, 1.0),

        vec4(0, 0, 102/255, 1.0),
        vec4(1, 1, 1, 1.0),
        vec4(1, 1, 1, 1.0),

        vec4(0, 0, 102/255, 1.0),
        vec4(1, 1, 1, 1.0),
        vec4(1, 1, 1, 1.0),
    ];


    gl.viewport( 0, 0, canvas.width, canvas.height );
    gl.clearColor( 204/255, 153/255, 102/255, 1 );
    gl.clear( gl.COLOR_BUFFER_BIT );

    //  Load shaders and initialize attribute buffers
    var program = initShaders( gl, "vertex-shader", "fragment-shader" );
    gl.useProgram( program );

    // Associate out shader variables with our data buffer
	var vPosition = gl.getAttribLocation(program, "vPosition");
    var vColor = gl.getAttribLocation(program, "vColor");

    // sky
    var skyBufferId = gl.createBuffer();
    gl.bindBuffer( gl.ARRAY_BUFFER, skyBufferId );
    gl.bufferData( gl.ARRAY_BUFFER, flatten(v_sky), gl.STATIC_DRAW );
    gl.vertexAttribPointer( vPosition, 2, gl.FLOAT, false, 0, 0 );
    gl.enableVertexAttribArray( vPosition );

    var skyColorBufferId = gl.createBuffer();
    gl.bindBuffer(gl.ARRAY_BUFFER, skyColorBufferId);
    gl.bufferData(gl.ARRAY_BUFFER, flatten(c_sky), gl.STATIC_DRAW);
    gl.vertexAttribPointer(vColor, 4, gl.FLOAT, false, 0, 0)
    gl.enableVertexAttribArray(vColor);

    gl.drawArrays( gl.TRIANGLE_STRIP, 0, 4);


    // sun
    var sunBufferId = gl.createBuffer();
    gl.bindBuffer( gl.ARRAY_BUFFER, sunBufferId );
    gl.bufferData( gl.ARRAY_BUFFER, flatten(v_sun), gl.STATIC_DRAW );
    gl.vertexAttribPointer( vPosition, 2, gl.FLOAT, false, 0, 0 );
    gl.enableVertexAttribArray( vPosition );

    var sunColorBufferId = gl.createBuffer();
    gl.bindBuffer(gl.ARRAY_BUFFER, sunColorBufferId);
    gl.bufferData(gl.ARRAY_BUFFER, flatten(c_sun), gl.STATIC_DRAW);
    gl.vertexAttribPointer(vColor, 4, gl.FLOAT, false, 0, 0)
    gl.enableVertexAttribArray(vColor);

    gl.drawArrays( gl.TRIANGLE_FAN, 0, 18);


    // pinwheel line
    var lineBufferId = gl.createBuffer();
    gl.bindBuffer( gl.ARRAY_BUFFER, lineBufferId );
    gl.bufferData( gl.ARRAY_BUFFER, flatten(v_pinwheel_line), gl.STATIC_DRAW );
    gl.vertexAttribPointer( vPosition, 2, gl.FLOAT, false, 0, 0 );
    gl.enableVertexAttribArray( vPosition );

    var lineColorBufferId = gl.createBuffer();
    gl.bindBuffer(gl.ARRAY_BUFFER, lineColorBufferId);
    gl.bufferData(gl.ARRAY_BUFFER, flatten(c_pinwheel_line), gl.STATIC_DRAW);
    gl.vertexAttribPointer(vColor, 4, gl.FLOAT, false, 0, 0)
    gl.enableVertexAttribArray(vColor);

    gl.drawArrays( gl.LINES, 0, 8);


    // pinwheel 1
    var pinwheelBufferId = gl.createBuffer();
    gl.bindBuffer( gl.ARRAY_BUFFER, pinwheelBufferId );
    gl.bufferData( gl.ARRAY_BUFFER, flatten(v_pinwheel), gl.STATIC_DRAW );
    gl.vertexAttribPointer( vPosition, 2, gl.FLOAT, false, 0, 0 );
    gl.enableVertexAttribArray( vPosition );

    var pinwheelColorBufferId = gl.createBuffer();
    gl.bindBuffer(gl.ARRAY_BUFFER, pinwheelColorBufferId);
    gl.bufferData(gl.ARRAY_BUFFER, flatten(c_pinwheel_1), gl.STATIC_DRAW);
    gl.vertexAttribPointer(vColor, 4, gl.FLOAT, false, 0, 0)
    gl.enableVertexAttribArray(vColor);

    gl.drawArrays( gl.TRIANGLE_FAN, 0, 13);


    // pinwheel 2
    var uOffset = gl.getUniformLocation(program, "uOffset");
    gl.uniform4fv(uOffset, [0.5, 0.1, 0, 0]);

    gl.bufferData(gl.ARRAY_BUFFER, flatten(c_pinwheel_2), gl.STATIC_DRAW);

    gl.drawArrays( gl.TRIANGLE_FAN, 0, 13);


    // pinwheel 3
    var uOffset = gl.getUniformLocation(program, "uOffset");
    gl.uniform4fv(uOffset, [1.0, -0.2, 0, 0]);

    gl.bufferData(gl.ARRAY_BUFFER, flatten(c_pinwheel_3), gl.STATIC_DRAW);

    gl.drawArrays( gl.TRIANGLE_FAN, 0, 13);


    // pinwheel 4
    var uOffset = gl.getUniformLocation(program, "uOffset");
    gl.uniform4fv(uOffset, [1.4, 0.1, 0, 0]);

    gl.bufferData(gl.ARRAY_BUFFER, flatten(c_pinwheel_1), gl.STATIC_DRAW);

    gl.drawArrays( gl.TRIANGLE_FAN, 0, 13);

};
