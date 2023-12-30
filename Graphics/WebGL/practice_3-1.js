
var gl;
var points;

window.onload = function init()
{
    var canvas = document.getElementById( "gl-canvas" );

    gl = WebGLUtils.setupWebGL( canvas );
    if ( !gl ) { alert( "WebGL isn't available" ); }


    // Configure WebGL
    var vertices = [
        vec2(0, 1),
        vec2(-0.5, 0.5),
        vec2(0.5, 0.5),

        vec2(0, 0.5),
        vec2(-0.5, 0),
        vec2(0.5, 0),

        vec2(0, 0),
        vec2(-0.5, -0.5),
        vec2(0.5, -0.5),

        vec2(-0.15, -0.5),
        vec2(-0.15, -1),
        vec2(0.15, -0.5),
        vec2(0.15, -1)
    ];

    var colors = [
        vec4(0.0, 1.0, 0.0, 1.0),
        vec4(0.0, 1.0, 0.0, 1.0),
        vec4(0.0, 1.0, 0.0, 1.0),

        vec4(0.0, 1.0, 0.0, 1.0),
        vec4(0.0, 1.0, 0.0, 1.0),
        vec4(0.0, 1.0, 0.0, 1.0),

        vec4(0.0, 1.0, 0.0, 1.0),
        vec4(0.0, 1.0, 0.0, 1.0),
        vec4(0.0, 1.0, 0.0, 1.0),

        vec4(0.5, 0.2, 0.0, 1.0),
        vec4(0.5, 0.2, 0.0, 1.0),
        vec4(0.5, 0.2, 0.0, 1.0),
        vec4(0.5, 0.2, 0.0, 1.0)
    ];

    gl.viewport( 0, 0, canvas.width, canvas.height );
    gl.clearColor( 1.0, 1.0, 1.0, 1.0 );

    //  Load shaders and initialize attribute buffers

    var program = initShaders( gl, "vertex-shader", "fragment-shader" );
    gl.useProgram( program );

    // Load the data into the GPU

    var vertexPositionBufferId = gl.createBuffer();
    gl.bindBuffer( gl.ARRAY_BUFFER, vertexPositionBufferId );
    gl.bufferData( gl.ARRAY_BUFFER, flatten(vertices), gl.STATIC_DRAW );

    // Associate vertex data buffer with shader variables

    var vPosition = gl.getAttribLocation( program, "vPosition" );
    gl.vertexAttribPointer( vPosition, 2, gl.FLOAT, false, 0, 0 );
    gl.enableVertexAttribArray( vPosition );


    var vertexColorBufferId = gl.createBuffer();
    gl.bindBuffer(gl.ARRAY_BUFFER, vertexColorBufferId);
    gl.bufferData(gl.ARRAY_BUFFER, flatten(colors), gl.STATIC_DRAW);

    var colorLoc = gl.getUniformLocation(program , "color");
    gl.uniform4f(colorLoc, 0.0, 1.0, 0.0, 1.0);


    render();

    gl.uniform4f(colorLoc, 0.5, 0.2, 0.0, 1.0);
    gl.drawArrays( gl.TRIANGLE_STRIP, 9, 4);

};


function render() {
    gl.clear( gl.COLOR_BUFFER_BIT );
    gl.drawArrays( gl.TRIANGLE_STRIP, 0, 3);
    gl.drawArrays( gl.TRIANGLE_STRIP, 3, 3);
    gl.drawArrays( gl.TRIANGLE_STRIP, 6, 3);

    
}
